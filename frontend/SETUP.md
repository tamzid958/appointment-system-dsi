## Docker Container Preparation

Clone the repository (no needed if already cloned):

```
git@github.com:tamzid958/appointment-system-dsi.git
cd appointment-system-dsi/frontend
git checkout main
```

Copy docker-compose.yml:

```
cp docker-compose.yaml.example docker-compose.yaml
```

Update docker-compose.yml file with database & others credentials (if needed) using vim:

```
vi docker-compose.yaml
```

or using nano:

```
nano docker-compose.yaml
```

Enable permission:

```
sudo chmod 666 /var/run/docker.sock
```

Build and run docker image:

```
docker compose build
docker compose up -d
```

To verify docker images are running:

```
docker compose ps
```

To check app container logs:

```
docker compose logs -f app
```

## Frontend Installation

Firstly navigate to your project directory and run the below command:

```
cp .env.docker .env
```

Update .env file with proper credentials & information (if needed) using vim:

```
vi .env
```

or using nano:

```
name .env
```

After this run the below npm command:

```
docker compose run --rm dsi_next npm run dev
```