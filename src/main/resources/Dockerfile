FROM postgres:10
ENV POSTGRES_USER project1db
ENV POSTGRES_PASSWORD project1db
ADD schema.sql /docker-entrypoint-initdb.d
EXPOSE 5432