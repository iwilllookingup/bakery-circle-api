package com.project.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;

@Data
@Accessors(chain = true)
public class UpdateTableStatusRequest {

  @NotNull private String status;
}
