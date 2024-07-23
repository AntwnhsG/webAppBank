package com.example.testinterview.domain;

import com.example.testinterview.domain.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Transaction extends BaseModel{

    private Long accountId;

    private Double balance;

    private TransactionType type;
}
