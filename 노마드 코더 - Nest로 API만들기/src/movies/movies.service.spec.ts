import { NotFoundException } from '@nestjs/common';
import { Test, TestingModule } from '@nestjs/testing';
import { MoviesService } from './movies.service';

describe('MoviesService', () => {
  let service: MoviesService;

  beforeEach(async () => {
    const module: TestingModule = await Test.createTestingModule({
      providers: [MoviesService],
    }).compile();

    service = module.get<MoviesService>(MoviesService);
  });

  it('should be defined', () => {
    expect(service).toBeDefined();
  });

  describe('getAll', () => {
    it('shoud return an array', () => {
      const result = service.getAll();
      expect(result).toBeInstanceOf(Array);
    });
  });

  describe('getOne', () => {
    it('shoud return a movie', () => {
      service.create({ title: 'title', year: 2032, genres: ['hi'] });

      const movie = service.getOne(1);

      expect(movie).toBeDefined();
      expect(movie.title).toEqual('title');
      expect(movie.id).toEqual(1);
    });

    it('should throw 404 error', () => {
      const findId = 999;
      try {
        service.getOne(findId);
      } catch (e) {
        expect(e).toBeInstanceOf(NotFoundException);
        expect(e.message).toEqual(`Movie with ID ${findId} not found`);
      }
    });
  });

  describe('deleteOne', () => {
    it('deletes a movie', () => {
      // given
      service.create({ title: 'title', year: 2032, genres: ['hi'] });
      const allMovies = service.getAll();

      // when
      service.deleteOne(1);
      const afterDelete = service.getAll();

      // then
      expect(afterDelete.length).toBeLessThan(allMovies.length);
    });

    it('should return a 404', () => {
      const deleteId = 999;
      try {
        service.deleteOne(deleteId);
      } catch (e) {
        expect(e).toBeInstanceOf(NotFoundException);
      }
    });
  });

  describe('update', () => {
    it('should update a movie', () => {
      //given
      service.create({ title: 'title', year: 2032, genres: ['hi'] });

      //when
      service.update(1, { title: 'new title' });
      const updatedMovie = service.getOne(1);

      //then
      expect(updatedMovie.title).toEqual('new title');
    });

    it('should throw a NotFoundException', () => {
      try {
        service.update(999, { title: 'hi' });
      } catch (e) {
        expect(e).toBeInstanceOf(NotFoundException);
      }
    });
  });
});
