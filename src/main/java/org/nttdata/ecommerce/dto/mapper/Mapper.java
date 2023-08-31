package org.nttdata.ecommerce.dto.mapper;

import org.modelmapper.ModelMapper;
import org.nttdata.ecommerce.domain.Product;
import org.nttdata.ecommerce.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    private final ModelMapper modelMapper;

    @Autowired
    public Mapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public Product toDomain(ProductDTO dto, Class<Product> p){
        return (dto == null) ? null : modelMapper.map(dto, p);
    }

    public ProductDTO toDTO(Product p, Class<ProductDTO> dto){
        return (p == null) ? null : modelMapper.map(p, dto);
    }
}

