package com.flyzfq.lich.model.base;

import com.google.common.collect.Lists;

import org.modelmapper.ModelMapper;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * Created by bug on 16/3/24.
 */
public class BaseConverterAdapter<DTOT, DOT> {
  protected static final ModelMapper modelMapper = new ModelMapper();

  public DOT toDO(DTOT dtoObject) {
    throw new UnsupportedOperationException();
  }

  public DTOT toDTO(DOT doObject) {
    throw new UnsupportedOperationException();
  }

  public List<DTOT> toDTOList(List<DOT> doList) {
    List<DTOT> dtoList = Lists.newArrayList();

    if (CollectionUtils.isEmpty(doList)) {
      return dtoList;
    }

    for (DOT doObject : doList) {
      dtoList.add(toDTO(doObject));
    }
    return dtoList;
  }
}
