package com.kosa.kosafinalprojbackend.domains.kanban.card.controller;

import com.kosa.kosafinalprojbackend.domains.kanban.card.domain.form.CardUpdateForm;
import com.kosa.kosafinalprojbackend.domains.kanban.card.service.CardService;
import com.kosa.kosafinalprojbackend.global.error.errorCode.ResponseCode;
import com.kosa.kosafinalprojbackend.global.security.model.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import static com.kosa.kosafinalprojbackend.global.error.errorCode.ResponseCode.KANBAN_CARD_DELETE;
import static com.kosa.kosafinalprojbackend.global.error.errorCode.ResponseCode.KANBAN_CARD_MODIFY_SUCCESS;
import static org.springframework.http.HttpStatus.OK;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/kanban-cards")
public class CardController {

  private final CardService kanbanCardService;


  // 칸반 카드 수정
  @PatchMapping("/{kanban-card-id}")
  public ResponseEntity<ResponseCode> updateKanbanCard(
      @AuthenticationPrincipal CustomUserDetails customUserDetails,
      @PathVariable("kanban-card-id") Long kanbanCardId,
      @RequestBody CardUpdateForm kanbanCardTitleForm) {

    kanbanCardService.updateKanbanCard(customUserDetails.getId(), kanbanCardId, kanbanCardTitleForm);

    return ResponseEntity.status(OK).body(KANBAN_CARD_MODIFY_SUCCESS);
  }

  // 칸반 카드 삭제
  @DeleteMapping("/{kanban-card-id}")
  public ResponseEntity<ResponseCode> deleteKanbanCard(
      @AuthenticationPrincipal CustomUserDetails customUserDetails,
      @PathVariable("kanban-card-id") Long kanbanCardId) {

    kanbanCardService.deleteKanbanCard(customUserDetails.getId(), kanbanCardId);

    return ResponseEntity.status(OK).body(KANBAN_CARD_DELETE);
  }
}
