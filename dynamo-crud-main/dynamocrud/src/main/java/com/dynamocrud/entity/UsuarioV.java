package com.dynamocrud.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamoDBTable(tableName = "")
public class UsuarioV {
    private int idUsuario;
    private String userName;
    private String password;
    private String roll;
    private String email;
}
