package edu.iesam.superheroes.features.superheroes.domain

import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.*
import org.junit.Test

class GetSuperHeroeUseCaseTest {

    /**
     * When ..... Then ....
     */
    @Test
    fun `when invoke then return superheroes from repository`() {
        // Given
        val repositoryMock = mockk<SuperHeroeRepository>(relaxed = true)
        val expectedSuperheroes = listOf(
            SuperHeroe("1", "Spider-Man", "spider-man", "url")
        )

        every { repositoryMock.get() } returns Result.success(expectedSuperheroes)

        val useCase = GetSuperHeroeUseCase(repositoryMock)

        // When
        val result = useCase.invoke()

        // Then
        verify(exactly = 1) { repositoryMock.get() }
        assertEquals(expectedSuperheroes, result.getOrNull())
    }

}