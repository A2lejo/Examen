FROM openjdk:latest

WORKDIR /CalculadoraBMI

COPY . /CalculadoraBMI

RUN javac CalculadoraBMI/*.java

EXPOSE 1099

CMD ["java", "CalculadoraBMI.ServidorRMI"]