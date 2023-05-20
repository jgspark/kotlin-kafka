# 도커

k8s 을 통해서 kafka 컨테이너 추가

## Docker Compose Up

- Docker-Compose to Start Container Command
- command use to root project

```bash
docker-compose -f ./k8s/docker-compose.yml up -d
```

![](img/도커_컴포스_업.png)

## Docker Compose Down

```bash 
docker-compose -f ./k8s/docker-compose.yml down
```

![](img/도커_컴포스_다운.png)

