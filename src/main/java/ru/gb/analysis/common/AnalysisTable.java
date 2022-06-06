package ru.gb.analysis.common;

import ru.gb.analysis.dto.ProductWithCategories;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnalysisTable {

    private List<ProductWithCategories> productsWithCategories;


}
