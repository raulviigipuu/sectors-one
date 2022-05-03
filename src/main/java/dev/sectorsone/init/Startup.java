package dev.sectorsone.init;

import dev.sectorsone.model.Sector;
import dev.sectorsone.repositories.SectorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Startup {
    @Autowired
    private SectorRepository sectorRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() {
        if(sectorRepository.count() > 0) {
            log.info("Sector table contains data, returning");
            return;
        }
        var manufacturing = createSector("Manufacturing", null);
        createSector("Construction materials", manufacturing);
        createSector("Electronics and Optics", manufacturing);
        var food = createSector("Food and Beverage", manufacturing);
        createSector("Bakery & confectionery products", food);
        createSector("Beverages", food);
        createSector("Fish & fish products", food);
        createSector("Meat & meat products", food);
        createSector("Milk & dairy products", food);
        createSector("Other", food);
        createSector("Sweets & snack food", food);
        var furniture = createSector("Furniture", manufacturing);
        createSector("Bathroom/sauna", furniture);
        createSector("Bedroom", furniture);
        createSector("Children's room", furniture);
        createSector("Kitchen", furniture);
        createSector("Living room", furniture);
        createSector("Office", furniture);
        createSector("Other (Furniture)", furniture);
        createSector("Outdoor", furniture);
        createSector("Project furniture", furniture);
        var machinery = createSector("Machinery", manufacturing);
        createSector("Machinery components", machinery);
        createSector("Machinery equipment/tools", machinery);
        createSector("Manufacture of machinery", machinery);
        var maritime =createSector("Maritime", machinery);
        createSector("Aluminium and steel workboats", maritime);
        createSector("Boat/Yacht building", maritime);
        createSector("Ship repair and conversion", maritime);
        createSector("Metal structures", machinery);
        createSector("Other", machinery);
        createSector("Repair and maintenance service", machinery);
        var metal = createSector("Metalworking", manufacturing);
        createSector("Construction of metal structures", metal);
        createSector("Houses and buildings", metal);
        createSector("Metal products", metal);
        var metalworks = createSector("Metal works", metal);
        createSector("CNC-machining", metalworks);
        createSector("Forgings, Fasteners", metalworks);
        createSector("Gas, Plasma, Laser cutting", metalworks);
        createSector("MIG, TIG, Aluminum welding", metalworks);
        var plastic = createSector("Plastic and Rubber", manufacturing);
        createSector("Packaging", plastic);
        createSector("Plastic goods", plastic);
        var processing = createSector("Plastic processing technology", plastic);
        createSector("Blowing", processing);
        createSector("Moulding", processing);
        createSector("Plastics welding and processing", processing);
        createSector("Plastic profiles", plastic);
        var printing = createSector("Printing", manufacturing);
        createSector("Advertising", printing);
        createSector("Book/Periodicals printing", printing);
        createSector("Labelling and packaging printing", printing);
        var textile = createSector("Textile and Clothing", manufacturing);
        createSector("Clothing", textile);
        createSector("Textile", textile);
        var wood = createSector("Wood", manufacturing);
        createSector("Other (Wood)", wood);
        createSector("Wooden building materials", wood);
        createSector("Wooden houses", wood);

        var service = createSector("Service", null);
        createSector("Business services", service);
        createSector("Engineering", service);
        var it = createSector("Information Technology and Telecommunications", service);
        createSector("Data processing, Web portals, E-marketing", it);
        createSector("Programming, Consultancy", it);
        createSector("Software, Hardware", it);
        createSector("Telecommunications", it);
        createSector("Tourism", service);
        createSector("Translation services", service);
        var transport = createSector("Transport and Logistics", service);
        createSector("Air", transport);
        createSector("Rail", transport);
        createSector("Road", transport);
        createSector("Water", transport);

        var other = createSector("Other", null);
        createSector("Creative industries", other);
        createSector("Energy technology", other);
        createSector("Environment", other);
        log.info("Added {} sectors to database.", sectorRepository.count());
    }

    private Sector createSector(String name, Sector parent) {
        var sector = new Sector();
        sector.setName(name);
        sector.setParent(parent);
        var savedSector = sectorRepository.save(sector);
        return savedSector;
    }
}
