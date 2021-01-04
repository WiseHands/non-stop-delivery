package ua.lviv.wdelivery.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.wdelivery.entity.NewRequest;

@Repository
public interface NewRequestRepository extends CrudRepository<NewRequest, Long> {

    NewRequest findByOrderNumber(String orderNumber);
    NewRequest findByOrderPrice(String orderPrice);
    NewRequest findByStreetName(String streetName);
    NewRequest findByBuildingName(String buildingName);
    NewRequest findByApartmentName(String apartmentName);
    NewRequest findByEntranceCode(String entranceCode);
}
