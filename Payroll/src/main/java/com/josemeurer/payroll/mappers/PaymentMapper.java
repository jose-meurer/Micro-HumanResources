package com.josemeurer.payroll.mappers;

import com.josemeurer.payroll.dtos.PaymentDto;
import com.josemeurer.payroll.entities.Payment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PaymentMapper {

    PaymentDto entityToDto(Payment entity);
    Payment dtoToEntity(PaymentDto dto);
}
