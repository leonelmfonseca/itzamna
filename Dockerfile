# Placing your Containerfile/Dockerfile in the root directory of your Spring Boot project
# is the recommended practice, as this maintains consistency and simplifies your build process.

# Use the official PostgreSQL image from Docker Hub
FROM docker.io/library/postgres:latest

# WARNING:
# if you use: "FROM postgres:latest" when exec "podman build .",
# you will get:
#       "Error: creating build container: short-name "postgres:latest" did not resolve to an alias
#       and no unqualified-search registries are defined in "/etc/containers/registries.conf"
# because it doesn’t know which registry to pull it from. \Unlike Docker, which defaults to Docker Hub for unqualified
# image names (e.g., postgres), Podman requires explicit configuration in /etc/containers/registries.conf for short names,
# or you need to provide the fully qualified image name.
# Podman is stricter about registry lookups to enhance security and avoid ambiguity.
# Your system’s:
#   /etc/containers/registries.conf
# likely doesn’t define any default "unqualified-search registries" (registries Podman checks when you don’t specify a domain like docker.io).
# Without this, Podman won’t assume postgres:latest means docker.io/library/postgres:latest

# FIX: Use the fully qualified image name to ensure Podman can resolve the image correctly.

ENV POSTGRES_USER=myuser
ENV POSTGRES_PASSWORD=mypassword
ENV POSTGRES_DB=mydatabase

# Expose the PostgreSQL port
EXPOSE 5432