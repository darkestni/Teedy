package com.sismics.util;

import com.sismics.docs.core.util.jpa.PaginatedList;
import com.sismics.docs.core.util.jpa.PaginatedLists;
import com.sismics.docs.core.util.jpa.SortCriteria;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Locale;

/**
 * Test locale and pagination utilities.
 */
public class TestLocaleAndPaginationUtil {
    @Test
    public void testGetLocale() {
        Assert.assertEquals(Locale.ENGLISH, LocaleUtil.getLocale(null));
        Assert.assertEquals(Locale.ENGLISH, LocaleUtil.getLocale(""));
        Assert.assertEquals(new Locale("fr"), LocaleUtil.getLocale("fr"));
        Assert.assertEquals(new Locale("zh", "CN"), LocaleUtil.getLocale("zh_CN"));
        Assert.assertEquals(new Locale("en", "US", "POSIX"), LocaleUtil.getLocale("en_US_POSIX"));
    }

    @Test
    public void testCreatePaginatedList() {
        PaginatedList<String> defaultPage = PaginatedLists.create();
        Assert.assertEquals(10, defaultPage.getLimit());
        Assert.assertEquals(0, defaultPage.getOffset());

        PaginatedList<String> explicitPage = PaginatedLists.create(25, 30);
        Assert.assertEquals(25, explicitPage.getLimit());
        Assert.assertEquals(30, explicitPage.getOffset());

        PaginatedList<String> cappedPage = PaginatedLists.create(250, null);
        Assert.assertEquals(100, cappedPage.getLimit());
        Assert.assertEquals(0, cappedPage.getOffset());

        cappedPage.setResultCount(2);
        cappedPage.setResultList(Arrays.asList("one", "two"));
        Assert.assertEquals(2, cappedPage.getResultCount());
        Assert.assertEquals(Arrays.asList("one", "two"), cappedPage.getResultList());
    }

    @Test
    public void testSortCriteria() {
        SortCriteria defaultSort = new SortCriteria(null, null);
        Assert.assertEquals(0, defaultSort.getColumn());
        Assert.assertTrue(defaultSort.isAsc());

        SortCriteria customSort = new SortCriteria(3, false);
        Assert.assertEquals(3, customSort.getColumn());
        Assert.assertFalse(customSort.isAsc());
    }
}
