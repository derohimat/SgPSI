package net.derohimat.sgpsi.data.models;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static net.derohimat.sgpsi.data.models.PsiReadingsType.CO8HourMax;
import static net.derohimat.sgpsi.data.models.PsiReadingsType.COSubIndex;
import static net.derohimat.sgpsi.data.models.PsiReadingsType.O38HourMax;
import static net.derohimat.sgpsi.data.models.PsiReadingsType.O3SubIndex;
import static net.derohimat.sgpsi.data.models.PsiReadingsType.PM10Daily;
import static net.derohimat.sgpsi.data.models.PsiReadingsType.PM10SubIndex;
import static net.derohimat.sgpsi.data.models.PsiReadingsType.PM25Daily;
import static net.derohimat.sgpsi.data.models.PsiReadingsType.PM25SubIndex;
import static net.derohimat.sgpsi.data.models.PsiReadingsType.PSIDaily;
import static net.derohimat.sgpsi.data.models.PsiReadingsType.SO2Daily;

@Retention(RetentionPolicy.SOURCE)
@IntDef({
        O3SubIndex,
        PM10Daily,
        PM10SubIndex,
        COSubIndex,
        PM25Daily,
        CO8HourMax,
        SO2Daily,
        PM25SubIndex,
        PSIDaily,
        O38HourMax
})
public @interface PsiReadingsType {
    int O3SubIndex = 0;
    int PM10Daily = 1;
    int PM10SubIndex = 2;
    int COSubIndex = 3;
    int PM25Daily = 4;
    int CO8HourMax = 5;
    int SO2Daily = 6;
    int PM25SubIndex = 7;
    int PSIDaily = 8;
    int O38HourMax = 9;
}