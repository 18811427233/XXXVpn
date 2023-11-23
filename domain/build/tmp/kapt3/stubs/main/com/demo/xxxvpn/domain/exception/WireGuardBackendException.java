package com.demo.xxxvpn.domain.exception;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002:\b\u0006\u0007\b\t\n\u000b\f\rB\u000f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005\u0082\u0001\b\u000e\u000f\u0010\u0011\u0012\u0013\u0014\u0015\u00a8\u0006\u0016"}, d2 = {"Lcom/demo/xxxvpn/domain/exception/WireGuardBackendException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "(Ljava/lang/String;)V", "DnsResolutionFailure", "MissingTunnelConfig", "TimeoutRetryLimitReached", "TunnelCreationError", "TunnelHandleNotFound", "UnknownError", "VpnConnectionTimeout", "VpnPermissionNotUnauthorized", "Lcom/demo/xxxvpn/domain/exception/WireGuardBackendException$DnsResolutionFailure;", "Lcom/demo/xxxvpn/domain/exception/WireGuardBackendException$MissingTunnelConfig;", "Lcom/demo/xxxvpn/domain/exception/WireGuardBackendException$TimeoutRetryLimitReached;", "Lcom/demo/xxxvpn/domain/exception/WireGuardBackendException$TunnelCreationError;", "Lcom/demo/xxxvpn/domain/exception/WireGuardBackendException$TunnelHandleNotFound;", "Lcom/demo/xxxvpn/domain/exception/WireGuardBackendException$UnknownError;", "Lcom/demo/xxxvpn/domain/exception/WireGuardBackendException$VpnConnectionTimeout;", "Lcom/demo/xxxvpn/domain/exception/WireGuardBackendException$VpnPermissionNotUnauthorized;", "domain"})
public abstract class WireGuardBackendException extends java.lang.RuntimeException {
    
    private WireGuardBackendException(java.lang.String message) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/demo/xxxvpn/domain/exception/WireGuardBackendException$DnsResolutionFailure;", "Lcom/demo/xxxvpn/domain/exception/WireGuardBackendException;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "domain"})
    public static final class DnsResolutionFailure extends com.demo.xxxvpn.domain.exception.WireGuardBackendException {
        @org.jetbrains.annotations.NotNull
        public static final com.demo.xxxvpn.domain.exception.WireGuardBackendException.DnsResolutionFailure INSTANCE = null;
        
        private DnsResolutionFailure() {
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/demo/xxxvpn/domain/exception/WireGuardBackendException$MissingTunnelConfig;", "Lcom/demo/xxxvpn/domain/exception/WireGuardBackendException;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "domain"})
    public static final class MissingTunnelConfig extends com.demo.xxxvpn.domain.exception.WireGuardBackendException {
        @org.jetbrains.annotations.NotNull
        public static final com.demo.xxxvpn.domain.exception.WireGuardBackendException.MissingTunnelConfig INSTANCE = null;
        
        private MissingTunnelConfig() {
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/demo/xxxvpn/domain/exception/WireGuardBackendException$TimeoutRetryLimitReached;", "Lcom/demo/xxxvpn/domain/exception/WireGuardBackendException;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "domain"})
    public static final class TimeoutRetryLimitReached extends com.demo.xxxvpn.domain.exception.WireGuardBackendException {
        @org.jetbrains.annotations.NotNull
        public static final com.demo.xxxvpn.domain.exception.WireGuardBackendException.TimeoutRetryLimitReached INSTANCE = null;
        
        private TimeoutRetryLimitReached() {
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/demo/xxxvpn/domain/exception/WireGuardBackendException$TunnelCreationError;", "Lcom/demo/xxxvpn/domain/exception/WireGuardBackendException;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "domain"})
    public static final class TunnelCreationError extends com.demo.xxxvpn.domain.exception.WireGuardBackendException {
        @org.jetbrains.annotations.NotNull
        public static final com.demo.xxxvpn.domain.exception.WireGuardBackendException.TunnelCreationError INSTANCE = null;
        
        private TunnelCreationError() {
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/demo/xxxvpn/domain/exception/WireGuardBackendException$TunnelHandleNotFound;", "Lcom/demo/xxxvpn/domain/exception/WireGuardBackendException;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "domain"})
    public static final class TunnelHandleNotFound extends com.demo.xxxvpn.domain.exception.WireGuardBackendException {
        @org.jetbrains.annotations.NotNull
        public static final com.demo.xxxvpn.domain.exception.WireGuardBackendException.TunnelHandleNotFound INSTANCE = null;
        
        private TunnelHandleNotFound() {
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/demo/xxxvpn/domain/exception/WireGuardBackendException$UnknownError;", "Lcom/demo/xxxvpn/domain/exception/WireGuardBackendException;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "domain"})
    public static final class UnknownError extends com.demo.xxxvpn.domain.exception.WireGuardBackendException {
        @org.jetbrains.annotations.NotNull
        public static final com.demo.xxxvpn.domain.exception.WireGuardBackendException.UnknownError INSTANCE = null;
        
        private UnknownError() {
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/demo/xxxvpn/domain/exception/WireGuardBackendException$VpnConnectionTimeout;", "Lcom/demo/xxxvpn/domain/exception/WireGuardBackendException;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "domain"})
    public static final class VpnConnectionTimeout extends com.demo.xxxvpn.domain.exception.WireGuardBackendException {
        @org.jetbrains.annotations.NotNull
        public static final com.demo.xxxvpn.domain.exception.WireGuardBackendException.VpnConnectionTimeout INSTANCE = null;
        
        private VpnConnectionTimeout() {
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u00c6\n\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0013\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u00d6\u0003J\t\u0010\u0007\u001a\u00020\bH\u00d6\u0001J\t\u0010\t\u001a\u00020\nH\u00d6\u0001\u00a8\u0006\u000b"}, d2 = {"Lcom/demo/xxxvpn/domain/exception/WireGuardBackendException$VpnPermissionNotUnauthorized;", "Lcom/demo/xxxvpn/domain/exception/WireGuardBackendException;", "()V", "equals", "", "other", "", "hashCode", "", "toString", "", "domain"})
    public static final class VpnPermissionNotUnauthorized extends com.demo.xxxvpn.domain.exception.WireGuardBackendException {
        @org.jetbrains.annotations.NotNull
        public static final com.demo.xxxvpn.domain.exception.WireGuardBackendException.VpnPermissionNotUnauthorized INSTANCE = null;
        
        private VpnPermissionNotUnauthorized() {
        }
        
        @java.lang.Override
        public boolean equals(@org.jetbrains.annotations.Nullable
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override
        @org.jetbrains.annotations.NotNull
        public java.lang.String toString() {
            return null;
        }
    }
}