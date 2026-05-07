package kg.build.flat_service.controller.request;

import jakarta.validation.Valid;
import kg.build.flat_service.dto.requests.BuyRequestCreateDto;
import kg.build.flat_service.dto.requests.BuyRequestDto;
import kg.build.flat_service.dto.requests.BuyRequestSearch;
import kg.build.flat_service.service.request.BuyRequestService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/buy-request")
@RequiredArgsConstructor
public class BuyRequestController {

    private final BuyRequestService buyRequestService;

    @GetMapping("/{id}")
    public BuyRequestDto getById(@PathVariable("id") Long id){
        return buyRequestService.getById(id);
    }

    @PostMapping
    public ResponseEntity<Void> createBuyRequest(@RequestBody @Valid BuyRequestCreateDto createDto){
        buyRequestService.createBuyRequest(createDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBuyRequest(@PathVariable("id") Long buyRequestId,
                                                 @RequestBody @Valid BuyRequestCreateDto createDto){
        buyRequestService.updateBuyRequest(buyRequestId, createDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBuyRequest(@PathVariable("id") Long requestId){
        buyRequestService.deleteBuyRequest(requestId);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/search")
    public Page<BuyRequestDto> searchBuyRequest(
            @RequestBody @Valid BuyRequestSearch searchRequest
    ){
        return buyRequestService.searchBuyRequest(searchRequest);
    }

}
