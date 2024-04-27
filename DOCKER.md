# DOCKER-BASED SETUP

## Docker Installation For Ubuntu Based System

First, update your existing list of packages:

```
sudo apt update
```

Next, install a few prerequisite packages which let apt use packages over HTTPS:

```
sudo apt install apt-transport-https ca-certificates curl software-properties-common
```

Then run the following command to uninstall all conflicting packages:

```
for pkg in docker.io docker-doc docker-compose docker-compose-v2 podman-docker containerd runc; do sudo apt-get remove $pkg; done
```

Set up Docker's apt repository:

```
# Add Docker's official GPG key:
sudo apt-get update
sudo apt-get install ca-certificates curl
sudo install -m 0755 -d /etc/apt/keyrings
sudo curl -fsSL https://download.docker.com/linux/ubuntu/gpg -o /etc/apt/keyrings/docker.asc
sudo chmod a+r /etc/apt/keyrings/docker.asc

# Add the repository to Apt sources:
echo \
  "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.asc] https://download.docker.com/linux/ubuntu \
  $(. /etc/os-release && echo "$VERSION_CODENAME") stable" | \
  sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
sudo apt-get update
```

Install the Docker packages:

```
sudo apt-get install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
```

Verify that the Docker Engine installation is successful by running the hello-world image:

```
sudo docker run hello-world
```

Check that it’s running:

```
sudo systemctl status docker
```

Start and enabling docker:

```
sudo systemctl start docker
sudo systemctl enable docker
```

Now you must have [Install Docker Desktop.](https://docs.docker.com/desktop/install/ubuntu/)

## Docker Container Preparation

Clone the repository:

```
git@github.com:tamzid958/appointment-system-dsi.git
cd appointment-system-dsi
git checkout main
```

Copy docker-compose.yml:

```
cp docker-compose.yaml.example docker-compose.yaml
```

Update docker-compose.yml file with database & others credentials using vim:

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

## Application Installation

Firstly navigate to your project directory and run the below command:

```
cp  .env.docker .env
```

Update .env file with proper credentials & information using vim:

```
vi .env
```

or using nano:

```
name .env
```

After this run the below mvn command:

```
docker compose run --rm dsi_spring mvn spring-boot:run
```