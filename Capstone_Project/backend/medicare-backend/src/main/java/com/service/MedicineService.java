package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repository.MedicineRepository;
import com.medicare.Medicine;
import com.exception.*;


@Service
public class MedicineService {
	
	@Autowired
	MedicineRepository medicineRepository;
	
	public String createMedicine(Medicine medicine) {
		medicine.setOriginalprice(medicine.getPrice());
		medicine.setEnable(true);
		medicineRepository.save(medicine);
		return "Medicine created";
	}


     public List<Medicine> findAllMedicine() {
	    return medicineRepository.findAll();
}
     
 	
	public String deleteMedicine(int mid) {
		Optional<Medicine> result = medicineRepository.findById(mid);
		if(result.isPresent()) {
			Medicine m = result.get();
			medicineRepository.delete(m);
			return "Medicine deleted successfully";
		}else {
			return "Medicine not present";
		}
	}
	
    public void updateProduct(int medicineid, Medicine updatedProduct) {
        Medicine existingProduct = medicineRepository.findById(medicineid)
                .orElseThrow();
        existingProduct.setDescription(updatedProduct.getDescription());
        existingProduct.setInventory(updatedProduct.getInventory());
        existingProduct.setName(updatedProduct.getName());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setEnable(updatedProduct.isEnable());
        existingProduct.setImageurl(updatedProduct.getImageurl());
        existingProduct.setOffer(updatedProduct.getOffer());
        if (updatedProduct.getOffer() == 0) {
        	existingProduct.setPrice(updatedProduct.getOriginalprice());
        }
        medicineRepository.save(existingProduct);
    }
    
    public List<Medicine> searchMedicine(String query) {
        return medicineRepository.findByNameContainingIgnoreCase(query);
    }
    
    public String enableMedicine(int medicineId) {
        Optional<Medicine> optionalMedicine = medicineRepository.findById(medicineId);
        if (optionalMedicine.isPresent()) {
            Medicine medicine = optionalMedicine.get();
            medicine.setEnable(true);
            medicineRepository.save(medicine);
            return "Medicine enabled";
        } else {
            return "Medicine not found";
        }
    }
    
    public String disableMedicine(int medicineId) {
        Optional<Medicine> optionalMedicine = medicineRepository.findById(medicineId);
        if (optionalMedicine.isPresent()) {
            Medicine medicine = optionalMedicine.get();
            medicine.setEnable(false);
            medicineRepository.save(medicine);
            return "Medicine disabled";
        } else {
            return "Medicine not found";
        }
    }
    
    public Medicine findMedicineById(int medicineId) {
        return medicineRepository.findById(medicineId).orElse(null);
    }
    
    public Medicine updateInventory(int medicineId, int newInventory) {
        Optional<Medicine> optionalMedicine = medicineRepository.findById(medicineId);
        if (optionalMedicine.isPresent()) {
            Medicine medicine = optionalMedicine.get();
            medicine.setInventory(newInventory);
            return medicineRepository.save(medicine);
        } else {
            throw new NotFoundException("Medicine not found");
        }
    }
    
}
    
     
