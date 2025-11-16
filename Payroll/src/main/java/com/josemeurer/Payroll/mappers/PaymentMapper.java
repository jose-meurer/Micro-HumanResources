package com.josemeurer.Payroll.mappers;

import com.josemeurer.Payroll.dtos.PaymentDto;
import com.josemeurer.Payroll.entities.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentDto entityToDto(Payment entity);
    Payment dtoToEntity(PaymentDto dto);
}
