# Pulse chat — Spring Boot + WebSocket

A compact WhatsApp-style room chat. Messages broadcast live over STOMP/WebSocket and are kept in memory for the life of the server.

```bash
docker compose up --build
# open http://localhost:8080
```

For production, add authentication/authorization, persist messages in a database, validate payloads, rate-limit connections, and place WebSocket traffic behind a TLS-capable reverse proxy.
