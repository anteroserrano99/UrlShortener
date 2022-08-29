FROM postgres:alpine

COPY ddl/UrlShortener.sql /docker-entrypoint-initdb.d/
ENV POSTGRES_USER docker
ENV POSTGRES_PASSWORD docker
ENV POSTGRES_DB docker

EXPOSE 5432