FROM eclipse-temurin:17-alpine
WORKDIR /app
COPY *.java ./
RUN javac Main.java
CMD ["java", "Main"]