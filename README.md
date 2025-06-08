# Entregador Service

Microserviço responsável por gerenciar entregadores e atribuições de entrega do projeto **UniFood**.

## Build sem acesso à internet

1. Em uma máquina com acesso à internet, execute:

   ```bash
   ./mvnw dependency:go-offline
   ```

   Isso fará o download de todas as dependências para o diretório `~/.m2`.
2. Copie a pasta `~/.m2/repository` para a máquina sem internet.
3. Na máquina offline, utilize o Maven em modo offline:

   ```bash
   ./mvnw -o clean package
   ```

## Endpoints principais

- `POST /api/entregadores` – cadastra um novo entregador
- `GET /api/entregadores/disponiveis` – lista entregadores disponíveis
- `PUT /api/entregadores/{id}/status?disponivel={true|false}` – atualiza disponibilidade
- `GET /api/entregadores/{id}` – busca entregador por ID
- `POST /api/entregadores/assign/{orderId}` – seleciona aleatoriamente um entregador disponível para o pedido indicado
- `POST /api/deliveries/assign` – atribui entregador ao pedido
- `PUT /api/deliveries/{entregaId}/status` – atualiza status da entrega
- `GET /api/deliveries/deliverer/{entregadorId}/assignments` – lista entregas pendentes para um entregador

Configure as URLs dos serviços externos (pedidos, clientes e restaurante) em `src/main/resources/application.properties`.

