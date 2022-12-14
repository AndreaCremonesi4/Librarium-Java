/*
 * This file is generated by jOOQ.
 */
package com.librarium.database.generated.org.jooq;


import com.librarium.database.generated.org.jooq.tables.Autori;
import com.librarium.database.generated.org.jooq.tables.Caseeditrici;
import com.librarium.database.generated.org.jooq.tables.Categorie;
import com.librarium.database.generated.org.jooq.tables.Libri;
import com.librarium.database.generated.org.jooq.tables.Utenti;
import com.librarium.database.generated.org.jooq.tables.records.AutoriRecord;
import com.librarium.database.generated.org.jooq.tables.records.CaseeditriciRecord;
import com.librarium.database.generated.org.jooq.tables.records.CategorieRecord;
import com.librarium.database.generated.org.jooq.tables.records.LibriRecord;
import com.librarium.database.generated.org.jooq.tables.records.UtentiRecord;

import org.jooq.ForeignKey;
import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in 
 * the default schema.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<AutoriRecord> PK_AUTORI = Internal.createUniqueKey(Autori.AUTORI, DSL.name("pk_Autori"), new TableField[] { Autori.AUTORI.ID }, true);
    public static final UniqueKey<CaseeditriciRecord> PK_CASEEDITRICI = Internal.createUniqueKey(Caseeditrici.CASEEDITRICI, DSL.name("pk_CaseEditrici"), new TableField[] { Caseeditrici.CASEEDITRICI.ID }, true);
    public static final UniqueKey<CategorieRecord> PK_CATEGORIE = Internal.createUniqueKey(Categorie.CATEGORIE, DSL.name("pk_Categorie"), new TableField[] { Categorie.CATEGORIE.ID }, true);
    public static final UniqueKey<LibriRecord> PK_LIBRI = Internal.createUniqueKey(Libri.LIBRI, DSL.name("pk_Libri"), new TableField[] { Libri.LIBRI.ID }, true);
    public static final UniqueKey<UtentiRecord> PK_UTENTI = Internal.createUniqueKey(Utenti.UTENTI, DSL.name("pk_Utenti"), new TableField[] { Utenti.UTENTI.ID }, true);
    public static final UniqueKey<UtentiRecord> SQLITE_AUTOINDEX_UTENTI_1 = Internal.createUniqueKey(Utenti.UTENTI, DSL.name("sqlite_autoindex_Utenti_1"), new TableField[] { Utenti.UTENTI.EMAIL }, true);

    // -------------------------------------------------------------------------
    // FOREIGN KEY definitions
    // -------------------------------------------------------------------------

    public static final ForeignKey<LibriRecord, AutoriRecord> FK_LIBRI_AUTORI_1 = Internal.createForeignKey(Libri.LIBRI, DSL.name("fk_Libri_Autori_1"), new TableField[] { Libri.LIBRI.AUTORE }, Keys.PK_AUTORI, new TableField[] { Autori.AUTORI.ID }, true);
    public static final ForeignKey<LibriRecord, CaseeditriciRecord> FK_LIBRI_CASEEDITRICI_1 = Internal.createForeignKey(Libri.LIBRI, DSL.name("fk_Libri_CaseEditrici_1"), new TableField[] { Libri.LIBRI.CASA_EDITRICE }, Keys.PK_CASEEDITRICI, new TableField[] { Caseeditrici.CASEEDITRICI.ID }, true);
    public static final ForeignKey<LibriRecord, CategorieRecord> FK_LIBRI_CATEGORIE_1 = Internal.createForeignKey(Libri.LIBRI, DSL.name("fk_Libri_Categorie_1"), new TableField[] { Libri.LIBRI.CATEGORIA }, Keys.PK_CATEGORIE, new TableField[] { Categorie.CATEGORIE.ID }, true);
}
