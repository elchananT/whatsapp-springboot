package com.portfolio.chat;
import java.time.Instant;
public record ChatMessage(String sender, String content, String room, Instant sentAt) {}
