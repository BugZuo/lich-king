package com.flyzfq.lich.web.assember;

import com.google.common.collect.Lists;

import org.apache.commons.collections.CollectionUtils;
import org.modelmapper.ModelMapper;

import java.util.List;

/**
 * Created by bug on 16/3/16.
 */
public class BaseAssemberAdapter<DTOT, DOT> {
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
