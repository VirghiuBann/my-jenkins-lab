# My Jenkins Labs

A Dockerized Jenkins setup with Jenkins UI and Docker-in-Docker (DinD) support.

## Stack

- Jenkins `2.541.3-jdk21` with plugins: `blueocean`, `docker-workflow`, `json-path-api`
- Docker-in-Docker (DinD) sidecar for running Docker builds inside pipelines
- Bridge network connecting both services

## Prerequisites

- Docker
- Docker Compose

## Usage

**Start:**

```bash
docker compose up -d
```

**Stop:**

```bash
docker compose down
```

**Access Jenkins:** http://localhost:8080

## Initial Setup

Retrieve the initial admin password:

```bash
docker exec jenkins-blueocean cat /var/jenkins_home/secrets/initialAdminPassword
```

## Volumes

| Volume                 | Purpose                                          |
| ---------------------- | ------------------------------------------------ |
| `jenkins-data`         | Jenkins home directory (jobs, configs, plugins)  |
| `jenkins-docker-certs` | TLS certificates for Docker daemon communication |

## Ports

| Port    | Service              |
| ------- | -------------------- |
| `8080`  | Jenkins Web UI       |
| `50000` | Jenkins agent (JNLP) |
| `2376`  | Docker daemon (TLS)  |
