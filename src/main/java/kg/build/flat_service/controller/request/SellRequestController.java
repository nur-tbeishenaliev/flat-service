package kg.build.flat_service.controller.request;

import jakarta.validation.Valid;
import kg.build.flat_service.dto.requests.SellRequestCreateDto;
import kg.build.flat_service.dto.requests.SellRequestSearch;
import kg.build.flat_service.service.request.SellRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import kg.build.flat_service.dto.requests.SellRequestDto;

@RestController
@RequestMapping("/sell-request")
@RequiredArgsConstructor
public class SellRequestController {

    private final SellRequestService sellRequestService;

    @GetMapping("/{id}")
    public SellRequestDto getById(@PathVariable("id") Long id){
        return sellRequestService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Void> createSellRequest(
            @RequestBody @Valid SellRequestCreateDto createDto){
        sellRequestService.create(createDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
     public ResponseEntity<Void> updateBuyRequest(@PathVariable("id") Long id,
                                                  @RequestBody @Valid SellRequestCreateDto createDto){
        sellRequestService.update(id, createDto);
        return ResponseEntity.ok().build();
     }

     @DeleteMapping("/{id}")
     public ResponseEntity<Void> deleteBuyRequest(Long id){
        sellRequestService.delete(id);
        return ResponseEntity.ok().build();
     }

     @PostMapping("/search")
     public Page<SellRequestDto> searchSellRequest(
             @RequestBody @Valid SellRequestSearch searchRequest
     ){
        return sellRequestService.searchByRequest(searchRequest);
     }
}
