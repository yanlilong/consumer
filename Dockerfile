FROM adoptopenjdk/openjdk11:ubi
#create addgoup
RUN groupadd  -r spring && useradd  -r -g spring  spring
USER spring:spring
ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","com.yanlilong.event.kafka.consumer.ConsumerApplication"]