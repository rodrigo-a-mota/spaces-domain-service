# -------------------------------------------
# Configurações da stack do serviço
# -------------------------------------------
env="labs"

# Variáveis de ambiente
environment=[
  {
    name  = "SPRING_PROFILES_ACTIVE"
    value = "labs"
  }
]

# Nome do serviço
name="spaces-domain-service"

# Rota do serviço
service_route="domain-service"

# Imagem ECR
image_repository="006375924004.dkr.ecr.us-east-1.amazonaws.com/spaces-domain-service"

# ARN do listener
listener_arn="arn:aws:elasticloadbalancing:us-east-1:006375924004:listener/app/spaces-alb-labs/82c438d2b4faa184/282368cce92838f0"

# Memória disponível para container
memory=512

# CPU disponível para container
cpu=512

# Quantidade de tasks desejadas
desidered=1

# Porta no target group
tg_port=8080