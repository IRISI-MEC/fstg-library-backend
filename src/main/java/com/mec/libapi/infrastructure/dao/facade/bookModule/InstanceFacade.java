package com.mec.libapi.infrastructure.dao.facade.bookModule;

import com.mec.libapi.domain.pojo.bookModule.Book;
import com.mec.libapi.domain.pojo.bookModule.Instance;
import com.mec.libapi.domain.pojo.bookModule.NCase;
import com.mec.libapi.infrastructure.dao.core.AbstractFacade;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Stream;

public interface InstanceFacade extends AbstractFacade<Instance, Long> {

    Stream<Instance> saveAll(List<Instance> instances);

    Instance findByQrCode(String qrcode);

    Instance findByInventoryNumber(Long inventoryNumber);

    Stream<Instance> findByEditor(String editor);

    Stream<Instance> findByEdition(String edition);

    Stream<Instance> findByPublishingDate(LocalDate date);

    Stream<Instance> findByLanguage(String language);

    Stream<Instance> findByBook(Book book);

    Stream<Instance> findByNCase(NCase nCase);

}
