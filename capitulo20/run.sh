
mvn verify 

docker build -t capitulo20 . 

docker run -d --rm -p 8080:8080 --name capitulo20 capitulo20