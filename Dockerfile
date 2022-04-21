FROM 006375924004.dkr.ecr.us-east-1.amazonaws.com/spaces-service-build AS build

# ----------------------------------------------------------
# Copiar arquivos tontes
# ----------------------------------------------------------
COPY --chown=gradle:gradle . /home/gradle/src

WORKDIR /home/gradle/src

# ----------------------------------------------------------
# Buildar aplicação
# ----------------------------------------------------------
RUN gradle clean build --continue --no-daemon

# ----------------------------------------------------------
# Criar diretório do serviço e move artefatos para o mesmo
# ----------------------------------------------------------
RUN mkdir -p /home/gradle/src/artifacts/__tmp && \
    mkdir -p /home/gradle/src/artifacts/__app && \
    mv /home/gradle/src/configuration/build/distributions/configuration-0.0.1-SNAPSHOT.tar /home/gradle/src/artifacts/__tmp

FROM 006375924004.dkr.ecr.us-east-1.amazonaws.com/spaces-service-base:latest

EXPOSE 8080

# ----------------------------------------------------------
# Copia artefatos para serem repassados
# ----------------------------------------------------------
COPY --from=build /home/gradle/src/artifacts /home/gradle/src/artifacts

# ----------------------------------------------------------
# Extrai artefatos
# ----------------------------------------------------------
RUN tar -xvf /home/gradle/src/artifacts/__tmp/configuration-0.0.1-SNAPSHOT.tar -C /home/gradle/src/artifacts/__app

# ----------------------------------------------------------
# Move para diretório de binários
# ----------------------------------------------------------
RUN mv /home/gradle/src/artifacts/__app/configuration-0.0.1-SNAPSHOT /bin/__app

ENTRYPOINT ["sh", "-c", "./bin/__app/bin/configuration"]