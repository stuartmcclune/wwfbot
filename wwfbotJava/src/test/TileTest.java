package test;

import main.Tile;
import main.TileType;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class TileTest {

  @Test
  public void correctEmptyString() {
    Tile tile = new Tile();
    assertThat(tile.toString(), is("   "));
  }

  @Test
  public void correctDWString() {
    Tile tile = new Tile(TileType.DW);
    assertThat(tile.toString(), is("DW "));
  }

  @Test
  public void correctTWString() {
    Tile tile = new Tile(TileType.TW);
    assertThat(tile.toString(), is("TW "));
  }

  @Test
  public void correctDLString() {
    Tile tile = new Tile(TileType.DL);
    assertThat(tile.toString(), is("DL "));
  }

  @Test
  public void correctTLString() {
    Tile tile = new Tile(TileType.TL);
    assertThat(tile.toString(), is("TL "));
  }

  @Test
  public void correctLetterString() {
    Tile tile = new Tile('h');
    assertThat(tile.toString(), is("h 3"));
  }

  @Test
  public void correctBlankString() {
    Tile tile = new Tile('h', true);
    assertThat(tile.toString(), is("h 0"));
  }

  @Test
  public void lettersAreLowercase1() {
    Tile tile = new Tile('H', true);
    assertThat(tile.toString(), is("h 0"));
  }

  @Test
  public void lettersAreLowercase2() {
    Tile tile = new Tile('H');
    assertThat(tile.toString(), is("h 3"));
  }

  @Test
  public void blanksAreBlank() {
    Tile tile = new Tile('a', true);
    assertTrue(tile.isBlank());
  }

  @Test
  public void notBlanksAreNotBlank1() {
    Tile tile = new Tile('a', false);
    assertFalse(tile.isBlank());
  }

  @Test
  public void notBlanksAreNotBlank2() {
    Tile tile = new Tile('a');
    assertFalse(tile.isBlank());
  }

}
