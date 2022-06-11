package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InvoiceTotalPriceDTO {
    private Integer companyID;
    private Integer invoiceID;
}
