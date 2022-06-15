package com.zzin.realfinal.repository;

import com.zzin.realfinal.model.ProductInfo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class ProductRepository {
    public HashMap<Integer, ProductInfo> map = new HashMap<>();

    public ProductRepository() {
        map.put(1,new ProductInfo(1, "순살 벌꿀 찜닭", "사양벌꿀로 구현한 단짠의 맛", 12900));
        map.put(2,new ProductInfo(2, "슈바인학센", "특제 블랙소스로 더욱 깊어진 풍미", 12000));
        map.put(3,new ProductInfo(3, "짬뽕 2인분", "매콤한 불맛이 담긴 한 그릇", 19000));
        map.put(4,new ProductInfo(4, "탱글탱글 국탕용 종합 어묵", "각양각색 어묵으로 완성하는 어묵탕", 11900));
        map.put(5,new ProductInfo(5, "냉채족발과 메밀면", "화려한 비주얼의 손님 접대용 요리", 24800));
        map.put(6,new ProductInfo(6, "감바스알아히요(2인)", "통통한 새우와 올리브오일에 찍어 먹는 색다른 맛의 스페인 까수엘라 매력에 푹 빠지실 거예요", 7000));
        map.put(7,new ProductInfo(7, "매콤 양념 순대볶음", "자꾸 당기는 추억속의 그 맛", 15900));
        map.put(8,new ProductInfo(8, "바질페스토 파스타", "집에서 간편히 해먹는 파스타", 17900));
        map.put(9,new ProductInfo(9, "김볼케이노 순두부 전골", "술집에서 사먹던 그 맛", 17900));
    }
}

