FROM openjdk:17-jdk-slim

WORKDIR /ecommerceapp

COPY ./src /ecommerceapp/src

RUN javac -d ./bin ./src/com/company/Main.java ./src/com/company/ReadConsole.java ./src/com/company/Controller/Catalog.java ./src/com/company/Model/Product.java ./src/com/company/Model/OrderAndPurchase.java ./src/com/company/Model/Customer.java


CMD ["java", "-classpath", "./bin", "com.company.Main"]