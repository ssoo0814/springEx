package com.multicampus.springex.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> {

    private int page;
    private int size;
    private int total;

    //시작 페이지 번호
    private int start;
    //끝페이지 번호
    private int end;

    //이전 페이지 존재의 여부
    private boolean prev;
    //다음 페이지 존재의 여부
    private boolean next;

    private List<E> dtoList;

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO, List<E> dtoList, int total){

        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();

        this.total = total;
        this.dtoList = dtoList;

        this.end = (int)(Math.ceil(this.page / 10.0)) * 10;

        this.start = this.end - 9;

        int last = (int)(Math.ceil((total/(double)size)));

        this.end = end > last ? last: end;

        this.prev = this.start > 1;

        this.next = total > this.end * this.size;
    }

    //페이지 번호의 계산
    /*현재 페이지 번호 (page)
    화면에 10개의 페이지 번호를 출력
        page 가 1인 경우 : 시작페이지 1, 마지막페이지 10
        page    10인 경우 :         1,            10
        page    11인 경우 :        11,            20
        page    21인 경우 :        21,            30

1.  this.end = (int) (Math.ceil(this.page / 10.0)) * 10;
    1/10 ==> ceil(0.1) ==> 1 * 10 ==> 10
    11/10 ==> ceil(1.1) ==> 2 * 10 ==> 20

2.  this.start = this.end - 9;

3.  전체 개수
    this.last = (int) (Math.ceil((total / (double)size)));
*/

}
