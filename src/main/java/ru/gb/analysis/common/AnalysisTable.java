package ru.gb.analysis.common;

import ru.gb.analysis.dto.ProductWithCategories;
import lombok.*;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
// Антипаттерн "Полтергейст" - в процессе создания данный класс не понадобился, оказалось, что во View можно направлять сразу ArrayList.
public class AnalysisTable {

    private List<ProductWithCategories> productsWithCategories;


}
