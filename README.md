## Endpoints principais

- `POST /api/entregadores` – cadastra um novo entregador  
- `GET /api/entregadores/disponiveis` – lista entregadores disponíveis  
- `PUT /api/entregadores/{id}/status?disponivel={true|false}` – atualiza disponibilidade  
- `GET /api/entregadores/{id}` – busca entregador por ID  
- `POST /api/entregadores/assign/{orderId}/{valorOrderId}` – atribui aleatoriamente um entregador ao pedido informando também o valor do pedido  
- `POST /api/deliveries/assign` – atribui entregador ao pedido  
- `PUT /api/deliveries/{entregaId}/status` – atualiza status da entrega
- `GET /api/deliveries/deliverer/{entregadorId}/assignments` – lista entregas em rota para um entregador
- `GET /api/deliveries/deliverer/active` – lista todas as entregas ativas

