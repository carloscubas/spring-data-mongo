CONTAINER_ID=$(docker container ls -qaf name=mongo-bolsa-familia)

if [ -z $CONTAINER_ID ]; then
	docker build -t mongo-bolsa:1.0 . &&
	docker run --name mongo-bolsa-familia -d -p 27017:27017 -p 28017:28017 -e AUTH=no mongo-bolsa:1.0 && 
	docker exec mongo-bolsa-familia mongoimport --host=127.0.0.1 -d governo -c bolsafamilia --type csv --file /tmp/bolsa.csv --headerline;
else
	docker start mongo-bolsa-familia
fi
