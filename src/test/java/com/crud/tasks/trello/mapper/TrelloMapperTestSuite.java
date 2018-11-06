package com.crud.tasks.trello.mapper;

import com.crud.tasks.domain.*;
import com.crud.tasks.mapper.TrelloMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTestSuite {
    @Autowired
    private TrelloMapper trelloMapper;
    @Test
    public void mapToBoardsDtoTest() {
        //Given
        TrelloBoard trelloBoard1 = new TrelloBoard("1","Board1",new ArrayList<>());
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(trelloBoard1);
        //when
        List<TrelloBoardDto> dtoBoards = trelloMapper.mapToBoardsDto(trelloBoards);
        //Then
        assertEquals(1,dtoBoards.size());
        assertEquals("Board1",dtoBoards.get(0).getName());
        assertEquals("1",dtoBoards.get(0).getId());
    }
    @Test
    public void mapToBoardsTest(){
        //Given
        TrelloBoardDto trelloBoardDto = new TrelloBoardDto("2","Board2",new ArrayList<>());
        List<TrelloBoardDto> trelloBoardDtoList = new ArrayList<>();
        trelloBoardDtoList.add(trelloBoardDto);
        //When
        List<TrelloBoard> trelloBoardList = trelloMapper.mapToBoards(trelloBoardDtoList);
        //Then
        assertEquals(1,trelloBoardList.size());
        assertEquals("2",trelloBoardList.get(0).getId());
        assertEquals("Board2",trelloBoardList.get(0).getName());
    }
    @Test
    public void mapToListTest(){
        //Given
        TrelloListDto trelloListDto = new TrelloListDto("1","list1",true);
        List<TrelloListDto> trelloListDtoList = new ArrayList<>();
        trelloListDtoList.add(trelloListDto);
        //When
        List<TrelloList> trelloListList = trelloMapper.mapToList(trelloListDtoList);
        //Then
        assertEquals(1,trelloListList.size());
        assertEquals("1",trelloListList.get(0).getId());
        assertEquals("list1",trelloListList.get(0).getName());
        assertEquals(true,trelloListList.get(0).isClosed());
    }
    @Test
    public void mapToListDtoTest() {
        //Given
        TrelloList trelloList = new TrelloList("2", "list2", false);
        List<TrelloList> trelloListList = new ArrayList<>();
        trelloListList.add(trelloList);
        //When
        List<TrelloListDto> trelloListDtoList = trelloMapper.mapToListDto(trelloListList);
        //Then
        assertEquals(1, trelloListDtoList.size());
        assertEquals("2", trelloListDtoList.get(0).getId());
        assertEquals("list2", trelloListDtoList.get(0).getName());
        assertEquals(false, trelloListDtoList.get(0).isClosed());
    }
    @Test
    public void mapToCardDtoTest(){
        //Given
        TrelloCard trelloCard = new TrelloCard("name","description","position","1");
        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);
        //Then
        assertEquals("name",trelloCardDto.getName());
        assertEquals("description",trelloCardDto.getDescription());
        assertEquals("position",trelloCardDto.getPos());
        assertEquals("1",trelloCardDto.getListId());
    }
    @Test
    public void mapToCardTest() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("name2", "description2", "position2", "2");
        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);
        //Then
        assertEquals("name2", trelloCard.getName());
        assertEquals("description2", trelloCard.getDescription());
        assertEquals("position2", trelloCard.getPos());
        assertEquals("2", trelloCard.getListId());
    }
}
