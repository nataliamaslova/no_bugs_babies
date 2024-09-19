package org.example.ui.datas;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BankAccount {
    private String firstName;
    private String lastName;
    private String address;
    private String city;

}
