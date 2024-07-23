package com.example.testinterview.api;

public record ApiError(Integer status, String message, String path) {
}
