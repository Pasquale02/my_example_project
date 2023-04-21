21-04-2023 [main] INFO  com.MyProjectMvnApplication -Starting MyProjectMvnApplication using Java 17.0.3 on FLORIOP-NB with PID 19088 (C:\Users\FLORIOP\Documents\progPoste\ms_my_proj\my_example_project\target\classes started by FLORIOP in C:\Users\FLORIOP\Documents\progPoste\ms_my_proj\my_example_project)
21-04-2023 [main] INFO  com.MyProjectMvnApplication -The following 1 profile is active: "dev"
21-04-2023 [main] INFO  o.s.d.r.c.RepositoryConfigurationDelegate -Bootstrapping Spring Data JPA repositories in DEFAULT mode.
21-04-2023 [main] INFO  o.s.d.r.c.RepositoryConfigurationDelegate -Finished Spring Data repository scanning in 250 ms. Found 1 JPA repository interfaces.
21-04-2023 [main] WARN  io.undertow.websockets.jsr -UT026010: Buffer pool was not set on WebSocketDeploymentInfo, the default pool will be used
21-04-2023 [main] INFO  io.undertow.servlet -Initializing Spring embedded WebApplicationContext
21-04-2023 [main] INFO  o.s.b.w.s.c.ServletWebServerApplicationContext -Root WebApplicationContext: initialization completed in 4209 ms
21-04-2023 [main] INFO  io.jaegertracing.Configuration -Initialized tracer=JaegerTracer(version=Java-0.35.1, serviceName=getUsersFromPlaceholder, reporter=CompositeReporter(reporters=[RemoteReporter(sender=UdpSender(), closeEnqueueTimeout=1000), LoggingReporter(logger=Logger[io.jaegertracing.internal.reporters.LoggingReporter])]), sampler=ConstSampler(decision=true, tags={sampler.type=const, sampler.param=true}), tags={hostname=FLORIOP-NB, jaeger.version=Java-0.35.1, ip=192.168.1.2}, zipkinSharedRpcSpan=false, expandExceptionLogs=false, useTraceId128Bit=false)
21-04-2023 [main] INFO  i.o.c.s.w.s.ServerTracingAutoConfiguration -Creating FilterRegistrationBean bean with TracingFilter mapped to [], skip pattern is "/api-docs.*|/swagger.*|.*\.png|.*\.css|.*\.js|.*\.html|/favicon.ico|/hystrix.stream|/actuator/(health|health/.*|info|info/.*|prometheus|prometheus/.*|metrics|metrics/.*)"
21-04-2023 [main] INFO  com.zaxxer.hikari.HikariDataSource -HikariPool-1 - Starting...
21-04-2023 [main] INFO  com.zaxxer.hikari.HikariDataSource -HikariPool-1 - Start completed.
21-04-2023 [main] INFO  o.h.jpa.internal.util.LogHelper -HHH000204: Processing PersistenceUnitInfo [name: default]
21-04-2023 [main] INFO  org.hibernate.Version -HHH000412: Hibernate ORM core version 5.6.7.Final
21-04-2023 [main] INFO  o.h.annotations.common.Version -HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
21-04-2023 [main] INFO  org.hibernate.dialect.Dialect -HHH000400: Using dialect: org.hibernate.dialect.PostgreSQL9Dialect
21-04-2023 [main] INFO  o.h.e.t.j.p.i.JtaPlatformInitiator -HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
21-04-2023 [main] INFO  o.s.o.j.LocalContainerEntityManagerFactoryBean -Initialized JPA EntityManagerFactory for persistence unit 'default'
21-04-2023 [main] INFO  i.o.c.s.w.s.ServerTracingAutoConfiguration -Creating WebMvcConfigurer bean with class io.opentracing.contrib.spring.web.interceptor.TracingHandlerInterceptor
21-04-2023 [main] WARN  o.s.b.a.o.j.JpaBaseConfiguration$JpaWebConfiguration -spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
21-04-2023 [main] INFO  o.s.b.a.e.web.EndpointLinksResolver -Exposing 4 endpoint(s) beneath base path '/actuator'
21-04-2023 [main] INFO  io.undertow -starting server: Undertow - 2.2.16.Final
21-04-2023 [main] INFO  org.xnio -XNIO version 3.8.6.Final
21-04-2023 [main] INFO  org.xnio.nio -XNIO NIO Implementation Version 3.8.6.Final
21-04-2023 [main] INFO  org.jboss.threads -JBoss Threads version 3.1.0.Final
21-04-2023 [main] INFO  o.s.b.w.e.undertow.UndertowWebServer -Undertow started on port(s) 8080 (http)
21-04-2023 [scheduling-1] INFO  com.scheduled.TaskScheduled -INFO: The time is now 16:43:26
21-04-2023 [main] INFO  com.MyProjectMvnApplication -Started MyProjectMvnApplication in 12.833 seconds (JVM running for 13.68)
21-04-2023 [scheduling-1] WARN  o.h.e.jdbc.spi.SqlExceptionHelper -SQL Error: 0, SQLState: 42P01
21-04-2023 [scheduling-1] ERROR o.h.e.jdbc.spi.SqlExceptionHelper -ERRORE: la relazione "utente" non esiste
  Posizione: 97
21-04-2023 [scheduling-1] ERROR com.scheduled.TaskScheduled -Eccezione nell'accesso a db: could not extract ResultSet; SQL [n/a]; nested exception is org.hibernate.exception.SQLGrammarException: could not extract ResultSet
21-04-2023 [scheduling-1] INFO  com.scheduled.TaskScheduled -INFO: The time is now 16:43:31
21-04-2023 [scheduling-1] WARN  o.h.e.jdbc.spi.SqlExceptionHelper -SQL Error: 0, SQLState: 42P01
21-04-2023 [scheduling-1] ERROR o.h.e.jdbc.spi.SqlExceptionHelper -ERRORE: la relazione "utente" non esiste
  Posizione: 97
21-04-2023 [scheduling-1] ERROR com.scheduled.TaskScheduled -Eccezione nell'accesso a db: could not extract ResultSet; SQL [n/a]; nested exception is org.hibernate.exception.SQLGrammarException: could not extract ResultSet
21-04-2023 [scheduling-1] INFO  com.scheduled.TaskScheduled -INFO: The time is now 16:43:36
21-04-2023 [scheduling-1] WARN  o.h.e.jdbc.spi.SqlExceptionHelper -SQL Error: 0, SQLState: 42P01
21-04-2023 [scheduling-1] ERROR o.h.e.jdbc.spi.SqlExceptionHelper -ERRORE: la relazione "utente" non esiste
  Posizione: 97
21-04-2023 [scheduling-1] ERROR com.scheduled.TaskScheduled -Eccezione nell'accesso a db: could not extract ResultSet; SQL [n/a]; nested exception is org.hibernate.exception.SQLGrammarException: could not extract ResultSet
21-04-2023 [scheduling-1] INFO  com.scheduled.TaskScheduled -INFO: The time is now 16:43:41
21-04-2023 [scheduling-1] WARN  o.h.e.jdbc.spi.SqlExceptionHelper -SQL Error: 0, SQLState: 42P01
21-04-2023 [scheduling-1] ERROR o.h.e.jdbc.spi.SqlExceptionHelper -ERRORE: la relazione "utente" non esiste
  Posizione: 97
21-04-2023 [scheduling-1] ERROR com.scheduled.TaskScheduled -Eccezione nell'accesso a db: could not extract ResultSet; SQL [n/a]; nested exception is org.hibernate.exception.SQLGrammarException: could not extract ResultSet
21-04-2023 [scheduling-1] INFO  com.scheduled.TaskScheduled -INFO: The time is now 16:43:46
21-04-2023 [scheduling-1] WARN  o.h.e.jdbc.spi.SqlExceptionHelper -SQL Error: 0, SQLState: 42P01
21-04-2023 [scheduling-1] ERROR o.h.e.jdbc.spi.SqlExceptionHelper -ERRORE: la relazione "utente" non esiste
  Posizione: 97
21-04-2023 [scheduling-1] ERROR com.scheduled.TaskScheduled -Eccezione nell'accesso a db: could not extract ResultSet; SQL [n/a]; nested exception is org.hibernate.exception.SQLGrammarException: could not extract ResultSet
21-04-2023 [main] INFO  com.MyProjectMvnApplication -Starting MyProjectMvnApplication using Java 17.0.3 on FLORIOP-NB with PID 18776 (C:\Users\FLORIOP\Documents\progPoste\ms_my_proj\my_example_project\target\classes started by FLORIOP in C:\Users\FLORIOP\Documents\progPoste\ms_my_proj\my_example_project)
21-04-2023 [main] INFO  com.MyProjectMvnApplication -The following 1 profile is active: "dev"
21-04-2023 [main] INFO  o.s.d.r.c.RepositoryConfigurationDelegate -Bootstrapping Spring Data JPA repositories in DEFAULT mode.
21-04-2023 [main] INFO  o.s.d.r.c.RepositoryConfigurationDelegate -Finished Spring Data repository scanning in 286 ms. Found 1 JPA repository interfaces.
21-04-2023 [main] WARN  io.undertow.websockets.jsr -UT026010: Buffer pool was not set on WebSocketDeploymentInfo, the default pool will be used
21-04-2023 [main] INFO  io.undertow.servlet -Initializing Spring embedded WebApplicationContext
21-04-2023 [main] INFO  o.s.b.w.s.c.ServletWebServerApplicationContext -Root WebApplicationContext: initialization completed in 4386 ms
21-04-2023 [main] INFO  io.jaegertracing.Configuration -Initialized tracer=JaegerTracer(version=Java-0.35.1, serviceName=getUsersFromPlaceholder, reporter=CompositeReporter(reporters=[RemoteReporter(sender=UdpSender(), closeEnqueueTimeout=1000), LoggingReporter(logger=Logger[io.jaegertracing.internal.reporters.LoggingReporter])]), sampler=ConstSampler(decision=true, tags={sampler.type=const, sampler.param=true}), tags={hostname=FLORIOP-NB, jaeger.version=Java-0.35.1, ip=192.168.1.2}, zipkinSharedRpcSpan=false, expandExceptionLogs=false, useTraceId128Bit=false)
21-04-2023 [main] INFO  i.o.c.s.w.s.ServerTracingAutoConfiguration -Creating FilterRegistrationBean bean with TracingFilter mapped to [], skip pattern is "/api-docs.*|/swagger.*|.*\.png|.*\.css|.*\.js|.*\.html|/favicon.ico|/hystrix.stream|/actuator/(health|health/.*|info|info/.*|prometheus|prometheus/.*|metrics|metrics/.*)"
21-04-2023 [main] INFO  com.zaxxer.hikari.HikariDataSource -HikariPool-1 - Starting...
21-04-2023 [main] INFO  com.zaxxer.hikari.HikariDataSource -HikariPool-1 - Start completed.
21-04-2023 [main] INFO  o.h.jpa.internal.util.LogHelper -HHH000204: Processing PersistenceUnitInfo [name: default]
21-04-2023 [main] INFO  org.hibernate.Version -HHH000412: Hibernate ORM core version 5.6.7.Final
21-04-2023 [main] INFO  o.h.annotations.common.Version -HCANN000001: Hibernate Commons Annotations {5.1.2.Final}
21-04-2023 [main] INFO  org.hibernate.dialect.Dialect -HHH000400: Using dialect: org.hibernate.dialect.PostgreSQL9Dialect
21-04-2023 [main] INFO  o.h.e.t.j.p.i.JtaPlatformInitiator -HHH000490: Using JtaPlatform implementation: [org.hibernate.engine.transaction.jta.platform.internal.NoJtaPlatform]
21-04-2023 [main] INFO  o.s.o.j.LocalContainerEntityManagerFactoryBean -Initialized JPA EntityManagerFactory for persistence unit 'default'
21-04-2023 [main] INFO  i.o.c.s.w.s.ServerTracingAutoConfiguration -Creating WebMvcConfigurer bean with class io.opentracing.contrib.spring.web.interceptor.TracingHandlerInterceptor
21-04-2023 [main] WARN  o.s.b.a.o.j.JpaBaseConfiguration$JpaWebConfiguration -spring.jpa.open-in-view is enabled by default. Therefore, database queries may be performed during view rendering. Explicitly configure spring.jpa.open-in-view to disable this warning
21-04-2023 [main] INFO  o.s.b.a.e.web.EndpointLinksResolver -Exposing 4 endpoint(s) beneath base path '/actuator'
21-04-2023 [main] INFO  io.undertow -starting server: Undertow - 2.2.16.Final
21-04-2023 [main] INFO  org.xnio -XNIO version 3.8.6.Final
21-04-2023 [main] INFO  org.xnio.nio -XNIO NIO Implementation Version 3.8.6.Final
21-04-2023 [main] INFO  org.jboss.threads -JBoss Threads version 3.1.0.Final
21-04-2023 [main] INFO  o.s.b.w.e.undertow.UndertowWebServer -Undertow started on port(s) 8080 (http)
21-04-2023 [main] INFO  com.MyProjectMvnApplication -Started MyProjectMvnApplication in 12.315 seconds (JVM running for 13.256)
21-04-2023 [scheduling-1] INFO  com.scheduled.TaskScheduled -INFO: The time is now 16:44:55
21-04-2023 [scheduling-1] DEBUG com.scheduled.TaskScheduled -DEBUG: The time is now 16:44:55
21-04-2023 [scheduling-1] WARN  o.h.e.jdbc.spi.SqlExceptionHelper -SQL Error: 0, SQLState: 42P01
21-04-2023 [scheduling-1] ERROR o.h.e.jdbc.spi.SqlExceptionHelper -ERRORE: la relazione "utente" non esiste
  Posizione: 97
21-04-2023 [scheduling-1] ERROR com.scheduled.TaskScheduled -Eccezione nell'accesso a db: could not extract ResultSet; SQL [n/a]; nested exception is org.hibernate.exception.SQLGrammarException: could not extract ResultSet
21-04-2023 [scheduling-1] INFO  com.scheduled.TaskScheduled -INFO: The time is now 16:45:00
21-04-2023 [scheduling-1] DEBUG com.scheduled.TaskScheduled -DEBUG: The time is now 16:45:00
21-04-2023 [scheduling-1] WARN  o.h.e.jdbc.spi.SqlExceptionHelper -SQL Error: 0, SQLState: 42P01
21-04-2023 [scheduling-1] ERROR o.h.e.jdbc.spi.SqlExceptionHelper -ERRORE: la relazione "utente" non esiste
  Posizione: 97
21-04-2023 [scheduling-1] ERROR com.scheduled.TaskScheduled -Eccezione nell'accesso a db: could not extract ResultSet; SQL [n/a]; nested exception is org.hibernate.exception.SQLGrammarException: could not extract ResultSet
