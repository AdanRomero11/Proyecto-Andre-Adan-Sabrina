package com.formacion.motos.servicios;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.formacion.motos.entidades.User;
import com.formacion.motos.entidades.api.Address;
import com.formacion.motos.entidades.api.Bank;
import com.formacion.motos.entidades.api.Company;
import com.formacion.motos.entidades.api.Crypto;
import com.formacion.motos.entidades.api.Hair;
import com.formacion.motos.repositorio.UserRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.restTemplate = new RestTemplate();
    }
    
    // 🔹 Método que obtiene todos los usuarios desde la BD
    public List<User> obtenerTodosLosUsuarios() {
        return userRepository.findAll();
    }
    
    public void updateUser(User user) throws Exception {
        Optional<User> existingUserOpt = userRepository.findById(user.getId());
        
        if (existingUserOpt.isPresent()) {
            User existingUser = existingUserOpt.get();
            // Actualizar los campos necesarios
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setImage(user.getImage());
            
            userRepository.save(existingUser); // Guarda los cambios
        } else {
            throw new Exception("Usuario no encontrado");
        }
    }

    public void fetchAndStoreUsers() {
        String url = "https://dummyjson.com/users";

        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        if (response != null && response.containsKey("users")) {
            List<Map<String, Object>> users = (List<Map<String, Object>>) response.get("users");

            for (Map<String, Object> userData : users) {
                User user = new User();
                user.setId(((Number) userData.get("id")).longValue());
                user.setFirstName((String) userData.get("firstName"));
                user.setLastName((String) userData.get("lastName"));
                user.setMaidenName((String) userData.get("maidenName"));
                user.setAge((Integer) userData.get("age"));
                user.setGender((String) userData.get("gender"));
                user.setEmail((String) userData.get("email"));
                user.setPhone((String) userData.get("phone"));
                user.setUsername((String) userData.get("username"));
                user.setPassword((String) userData.get("password"));
                user.setBirthDate((String) userData.get("birthDate"));
                user.setImage((String) userData.get("image"));
                user.setBloodGroup((String) userData.get("bloodGroup"));
                user.setHeight(((Number) userData.get("height")).doubleValue());
                user.setWeight(((Number) userData.get("weight")).doubleValue());
                user.setEyeColor((String) userData.get("eyeColor"));
                user.setIp((String) userData.get("ip"));
                user.setMacAddress((String) userData.get("macAddress"));
                user.setUniversity((String) userData.get("university"));
                user.setEin((String) userData.get("ein"));
                user.setSsn((String) userData.get("ssn"));
                user.setUserAgent((String) userData.get("userAgent"));
                user.setRole((String) userData.get("role"));

                // Mapeo de Hair
                Map<String, Object> hairData = (Map<String, Object>) userData.get("hair");
                if (hairData != null) {
                    Hair hair = new Hair();
                    hair.setColor((String) hairData.get("color"));
                    hair.setType((String) hairData.get("type"));
                    user.setHair(hair);
                }

                // Mapeo de Address
                Map<String, Object> addressData = (Map<String, Object>) userData.get("address");
                if (addressData != null) {
                    Address address = new Address();
                    address.setAddress((String) addressData.get("address"));
                    address.setCity((String) addressData.get("city"));
                    address.setState((String) addressData.get("state"));
                    address.setStateCode((String) addressData.get("stateCode"));
                    address.setPostalCode((String) addressData.get("postalCode"));
                    address.setCountry((String) addressData.get("country"));
                    user.setAddress(address);
                }

                // Mapeo de Company
                Map<String, Object> companyData = (Map<String, Object>) userData.get("company");
                if (companyData != null) {
                    Company company = new Company();
                    company.setDepartment((String) companyData.get("department"));
                    company.setName((String) companyData.get("name"));
                    company.setTitle((String) companyData.get("title"));
                    user.setCompany(company);
                }

                // Mapeo de Bank
                Map<String, Object> bankData = (Map<String, Object>) userData.get("bank");
                if (bankData != null) {
                    Bank bank = new Bank();
                    bank.setCardExpire((String) bankData.get("cardExpire"));
                    bank.setCardNumber((String) bankData.get("cardNumber"));
                    bank.setCardType((String) bankData.get("cardType"));
                    bank.setCurrency((String) bankData.get("currency"));
                    bank.setIban((String) bankData.get("iban"));
                    user.setBank(bank);
                }

                // Mapeo de Crypto
                Map<String, Object> cryptoData = (Map<String, Object>) userData.get("crypto");
                if (cryptoData != null) {
                    Crypto crypto = new Crypto();
                    crypto.setCoin((String) cryptoData.get("coin"));
                    crypto.setWallet((String) cryptoData.get("wallet"));
                    crypto.setNetwork((String) cryptoData.get("network"));
                    user.setCrypto(crypto);
                }

                userRepository.save(user);
            }
        }
    }
}

