rabbitmqctl list_queues
rabbitmqctl add_queue pessoa-fisica-relatorio-queue
curl -u guest:guest -XPUT -H "content-type:application/json" -d '{"auto_delete":false,"durable":true,"arguments":{}}' http://rabbitmq:15672/api/queues/%2F/pessoa-fisica-relatorio-queue
curl -u guest:guest -XPUT -H "content-type:application/json" -d '{"auto_delete":false,"durable":true,"arguments":{}}' http://localhost:15672/api/queues/%2F/pessoa-fisica-relatorio-queue
docker exec -it rabbitmq bash
apt update && apt install -y curl
curl -u guest:guest -XPUT -H "content-type:application/json" -d '{"auto_delete":false,"durable":true,"arguments":{}}' http://localhost:15672/api/queues/%2F/pessoa-fisica-relatorio-queue
rabbitmqctl list_queues
]q
exit
rabbitmqctl list_queues
rabbitmqadmin declare queue name=pessoa-fisica-relatorio-queue durable=true
rabbitmqctl list_queues
exit
rabbitmqctl list_queues
curl -u guest:guest -XPUT -H "content-type:application/json" -d '{"auto_delete":false,"durable":true,"arguments":{}}' http://localhost:15672/api/queues/%2F/pessoa-fisica-relatorio-queue
rabbitmqadmin declare queue name=pessoa-fisica-relatorio-queue durable=true
rabbitmqctl list_queues
wexit
exit
rabbitmqctl list_queues
exit
