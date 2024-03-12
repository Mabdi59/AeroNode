package com.aviation.management.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {

   private int id;
   private String username;
   @JsonIgnore
   private String password;
   private String role;
   private LocalDateTime createdAt;
   private LocalDateTime updatedAt;
   @JsonIgnore
   private boolean activated;
   private Set<Authority> authorities = new HashSet<>();

   public User() {}

   public User(int id, String username, String password, String role, Set<Authority> authorities, boolean activated) {
      this.id = id;
      this.username = username;
      this.password = password;
      this.role = role;
      this.authorities = authorities != null ? authorities : new HashSet<>();
      this.activated = activated;
      this.createdAt = LocalDateTime.now();
      this.updatedAt = LocalDateTime.now();
   }

   // Getters and Setters

   public int getId() {
      return id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public String getUsername() {
      return username;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public String getPassword() {
      return password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getRole() {
      return role;
   }

   public void setRole(String role) {
      this.role = role;
   }

   public LocalDateTime getCreatedAt() {
      return createdAt;
   }

   public void setCreatedAt(LocalDateTime createdAt) {
      this.createdAt = createdAt;
   }

   public LocalDateTime getUpdatedAt() {
      return updatedAt;
   }

   public void setUpdatedAt(LocalDateTime updatedAt) {
      this.updatedAt = updatedAt;
   }

   public boolean isActivated() {
      return activated;
   }

   public void setActivated(boolean activated) {
      this.activated = activated;
   }

   public Set<Authority> getAuthorities() {
      return authorities;
   }

   public void setAuthorities(Set<Authority> authorities) {
      this.authorities = authorities;
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      User user = (User) o;
      return id == user.id &&
              activated == user.activated &&
              Objects.equals(username, user.username) &&
              Objects.equals(password, user.password) &&
              Objects.equals(role, user.role) &&
              Objects.equals(authorities, user.authorities) &&
              Objects.equals(createdAt, user.createdAt) &&
              Objects.equals(updatedAt, user.updatedAt);
   }

   @Override
   public int hashCode() {
      return Objects.hash(id, username, password, role, activated, authorities, createdAt, updatedAt);
   }

   @Override
   public String toString() {
      return "User{" +
              "id=" + id +
              ", username='" + username + '\'' +
              ", role='" + role + '\'' +
              ", activated=" + activated +
              ", authorities=" + authorities +
              ", createdAt=" + createdAt +
              ", updatedAt=" + updatedAt +
              '}';
   }
}
